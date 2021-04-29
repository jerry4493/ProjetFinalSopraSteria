import { Employe } from './../../model/employe';
import { from, Observable } from 'rxjs';
import { InscriptionService } from './../../services/inscription.service';
import { Router } from '@angular/router';

import {
  FormControl,
  FormGroup,
  FormBuilder,
  Validators,
  AsyncValidatorFn,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { debounceTime, map } from 'rxjs/operators';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  employe = new Employe();
  nomCtrl: FormControl;
  prenomCtrl: FormControl;
  managerCtrl: FormControl;
  loginCtrl: FormControl;
  passwordCtrl: FormControl;
  serviceCtrl: FormControl;
  confirmationCtrl: FormControl;
  passwordGroup: FormGroup;
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private inscriptionServie: InscriptionService
  ) {
    this.nomCtrl = this.fb.control(
      '',
      [Validators.required, Validators.minLength(3)],
      this.controlNom()
    );
    this.prenomCtrl = this.fb.control(
      '',
      [Validators.required, Validators.minLength(3)],
      this.controlPrenom()
    );
    this.managerCtrl = this.fb.control(
      '',
      [Validators.required, Validators.pattern('/d')],
      this.controlManager()
    );
    this.serviceCtrl = this.fb.control(
      '',
      [Validators.required, Validators.minLength(3)],
      this.controlService()
    );
    this.loginCtrl = this.fb.control(
      '',
      [
        Validators.required,
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$'),
      ],
      this.controlLogin()
    );
    this.passwordCtrl = this.fb.control('', [
      Validators.required,
      Validators.pattern(/^(?=.*\d)(?=.*[a-zA-Z])([a-zA-Z0-9]{3,})$/),
    ]);
    this.confirmationCtrl = this.fb.control('', Validators.required);
    this.passwordGroup = this.fb.group(
      {
        password: this.passwordCtrl,
        confirmation: this.confirmationCtrl,
      },
      {
        validators: this.checkPassword,
      }
    );
    this.form = this.fb.group({
      login: this.loginCtrl,
      passwordGroup: this.passwordGroup,
    });
  }

  ngOnInit(): void {}

  controlLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.inscriptionServie.checkLogin(control.value).pipe(
        debounceTime(500),
        map((result: boolean) => {
          return result ? { loginExist: true } : null;
        })
      );
    };
  }
  controlNom(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.inscriptionServie.checkNom(control.value).pipe(
        debounceTime(500),
        map((result: boolean) => {
          return result ? { nomExist: true } : null;
        })
      );
    };
  }
  controlPrenom(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.inscriptionServie.checkPrenom(control.value).pipe(
        debounceTime(500),
        map((result: boolean) => {
          return result ? { nomExist: true } : null;
        })
      );
    };
  }
  controlManager(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.inscriptionServie.checkManager(control.value).pipe(
        debounceTime(500),
        map((result: boolean) => {
          return result ? { nomExist: true } : null;
        })
      );
    };
  }
  controlService(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.inscriptionServie.checkService(control.value).pipe(
        debounceTime(500),
        map((result: boolean) => {
          return result ? { nomExist: true } : null;
        })
      );
    };
  }
  checkPassword(group: FormGroup) {
    const password = group.controls['password'];
    const confirmation = group.controls.confirmation;
    if (password.errors) {
      return null;
    }
    return password.value != confirmation.value ? { notEquals: true } : null;
  }

  send() {
    this.inscriptionServie
      .inscription(
        this.nomCtrl.value,
        this.prenomCtrl.value,
        this.managerCtrl.value,
        this.serviceCtrl.value,
        this.loginCtrl.value,
        this.passwordCtrl.value
      )
      .subscribe((res) => {
        this.router.navigate(['/login']);
      });
  }

  nomIsInvalid(): boolean {
    return this.nomCtrl.dirty && this.nomCtrl.invalid;
  }

  prenomIsInvalid(): boolean {
    return this.prenomCtrl.dirty && this.prenomCtrl.invalid;
  }
  managerIsInvalid(): boolean {
    return this.managerCtrl.dirty && this.managerCtrl.invalid;
  }
  serviceIsInvalid(): boolean {
    return this.serviceCtrl.dirty && this.serviceCtrl.invalid;
  }
  loginIsInvalid(): boolean {
    return this.loginCtrl.dirty && this.loginCtrl.invalid;
  }

  passwordIsInvalid(): boolean {
    return this.passwordCtrl.dirty && this.passwordCtrl.invalid;
  }

  passwordGroupIsInvalid() {
    return this.passwordGroup.dirty && this.passwordGroup.invalid;
  }
}
