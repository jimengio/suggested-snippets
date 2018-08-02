
  async immerState(f: (s:IState)=>void) {
    return new Promise((resolve) => {
      this.setState(produce(f), () => {
        resolve();
      });
    });
  }