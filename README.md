# CodeChallenge

## Build Status

Prime Frontend: ![Build Status](https://codebuild.us-west-2.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoieFlGbGplMVYwdk00S0xXTEs4QURTRTJPeWJmaTdDbGZoVUR1NmZZNFp4NjA4SHU5ckdoRjZUU2RiL3B6WnVjL3BEeXZmNUpZblAvQmVxQkRjLzY2NzFVPSIsIml2UGFyYW1ldGVyU3BlYyI6IkJDcTF4RGNRdGR0K0xtejAiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)
Prime Backend: ![Build Status](https://codebuild.us-west-2.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiWVRrNkU3TTdLYXY3cUNrUWhjYzg3R2RVWDYyMm4wUFM3UVNqZnFjYnRDWThvL3hTTnZJWis4dG9sc1c3MHdNWS92dTRQUnBsM2htOHFoOC92T3A3Z2RNPSIsIml2UGFyYW1ldGVyU3BlYyI6Ik1oM0ZId2ZieXZrUHF5VEsiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)


This repo will deploy sample code challenge project to multiple environments to AWS, Azure and openshift through the different CI Platforms as AWS CodePipeline, Azure pipeline (Azure DevOps) and Jenkins pipeline.

We will be using this Github repository as our input source code repository.

## AWS Infrastructure &  Deployment

## Step 1:

In the [deployment/aws](deployment/aws/) directory there are multiple YAML (*CloudFormation Templates*) & JSON (*CloudFormation Configuration*) files.

**[vpc-stack.yml](deployment/aws/vpc-stack.yml):** is the CloudFormation template to create the base VPC, Subnets, NAT Gateways, etc which will be used.
**[vpc-params.json](deployment/aws/vpc-params.json):** is the parameters file which contains the parameter values for the CFN template. Update the 
  *ApprovalEmail* values to provide the appropriate email address.

## Step 2:

As a prerequisites, you need to create ECR repositories and you can create repositories based on your requirement [ecr.yamll](deployment/aws/ecr.yaml) cloudFormation template.

Go to `deployment/aws` directory and execute the following AWS CLI command to create CloudFormation stack.

```bash
cd deployment/aws
aws cloudformation create-stack --stack-name ecr-{yourRepositoryName}-stack --template-body file://ecr.yaml --parameters ParameterKey=repositoryName,ParameterValue=ecr-primefrontend --profile kulpreet-aot --region us-west-2

aws cloudformation create-stack --stack-name ecr-primefrontend-stack --template-body file://ecr.yaml --parameters ParameterKey=repositoryName,ParameterValue=ecr-primefrontend --capabilities CAPABILITY_NAMED_IAM --profile kulpreet-aot --region us-west-2
```