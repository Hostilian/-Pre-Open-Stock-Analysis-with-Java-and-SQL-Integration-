import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '39acb03e-1e35-463f-9018-e00a31b5f14d',
};

export const sampleWithPartialData: IAuthority = {
  name: '958f1076-b734-4817-b53c-7eb1b37626db',
};

export const sampleWithFullData: IAuthority = {
  name: 'ad2fefa9-e640-4ea7-b8de-0bd242291695',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
