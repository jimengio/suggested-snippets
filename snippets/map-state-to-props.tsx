
const mapStateToProps = (store:IReduxGlobalState, ownProps: IProps)=> {
  return {
    plants: store.globals.plants || []
  }
}

import {connect} from 'react-redux';

@connect(mapStateToProps)
