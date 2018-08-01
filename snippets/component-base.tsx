
import React from "react";
import { css, cx } from "emotion";
import produce from "immer";

interface IProps {}

interface IState {}

export default class DiagramCard extends React.Component<IProps, IState> {
  constructor(props) {
    super(props);

    this.state = {};
  }

  immerState(f: (s: IState) => void) {
    this.setState(produce(f));
  }

  render() {
    return <div>card</div>;
  }
}
