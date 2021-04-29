export class Login {
  public constructor(
    private _id?: number,
    private _email?: string,
    private _password?: string,
    private _role?: string
  ) {}

  public get id(): number {
    return this._id;
  }

  public set id(value: number) {
    this._id = value;
  }

  public get email(): string {
    return this._email;
  }

  public set email(value: string) {
    this._email = value;
  }

  public get password(): string {
    return this._password;
  }

  public set password(value: string) {
    this._password = value;
  }

  public get role(): string {
    return this._role;
  }

  public set role(value: string) {
    this._role = value;
  }
}
