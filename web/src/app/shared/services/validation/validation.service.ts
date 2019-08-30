import { Injectable } from '@angular/core';
import { AbstractControl, ValidatorFn } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ValidationService {

  public static emptyOrFixedLengthNumberValidator(length: number): ValidatorFn {
    return (control: AbstractControl): { [key: string]: boolean } | null => {
      if (control.value && (isNaN(control.value) || control.value.length !== length)) {
        return { emptyOrNumber : true };
      }
      return null;
    };
  }
}
