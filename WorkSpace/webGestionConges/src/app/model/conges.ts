export class Conges {
  public constructor(
    private _id?: number,
    private _dateDemande?: Date,
    private _dateDebut?: Date,
    private _dateFin?: Date,
    private _motif?: string,
    private _type?: string
  ) {}

  public get id(): number {
    return this._id;
  }

  public set id(value: number) {
    this._id = value;
  }

  public get dateDemande(): Date {
    return this._dateDemande;
  }

  public set dateDemande(value: Date) {
    this._dateDemande = value;
  }

  public get dateDebut(): Date {
    return this._dateDebut;
  }

  public set dateDebut(value: Date) {
    this._dateDebut = value;
  }

  public get dateFin(): Date {
    return this._dateFin;
  }

  public set dateFin(value: Date) {
    this._dateFin = value;
  }

  public get motif(): string {
    return this._motif;
  }

  public set motif(value: string) {
    this._motif = value;
  }

  public get type(): string {
    return this._type;
  }

  public set type(value: string) {
    this._type = value;
  }
}
