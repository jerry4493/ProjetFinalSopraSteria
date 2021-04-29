import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class CanActivateService implements CanActivate {
  constructor() {}

  canActivate(): boolean {
    return localStorage.getItem('auth') ? true : false;
  }
}
