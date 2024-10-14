import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 19358,
  login: 'DGCqbK',
};

export const sampleWithPartialData: IUser = {
  id: 23559,
  login: '4XEm',
};

export const sampleWithFullData: IUser = {
  id: 8495,
  login: 'HvDe',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
