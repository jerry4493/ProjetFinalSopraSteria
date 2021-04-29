import { Service } from './service';
import { Login } from './login';
import { Manager } from './manager';
export class Employe {
  public constructor(
    private _id?: number,
    private _nom?: string,
    private _prenom?: string,
    private _manager?: Manager,
    private _login?: Login,
    private _service?: Service
  ) {}

  public get id(): number {
    return this._id;
  }

  public set id(value: number) {
    this._id = value;
  }

  public get nom(): string {
    return this._nom;
  }

  public set nom(value: string) {
    this._nom = value;
  }

  public get prenom(): string {
    return this._prenom;
  }

  public set prenom(value: string) {
    this._prenom = value;
  }

  public get manager(): Manager {
    return this._manager;
  }

  public set manager(value: Manager) {
    this._manager = value;
  }

  public get login(): Login {
    return this._login;
  }

  public set login(value: Login) {
    this._login = value;
  }

  public get service(): Service {
    return this._service;
  }

  public set service(value: Service) {
    this._service = value;
  }
}
