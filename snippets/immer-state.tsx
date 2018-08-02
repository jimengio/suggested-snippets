
immerState(f: (s: IState) => void, cb?) {
  this.setState(produce(f), cb);
}

import produce from 'immer'