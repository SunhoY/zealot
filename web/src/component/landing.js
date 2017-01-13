import React, {Component} from 'react';
import 

const style = {
    container: {
        width: "100%",
        height: "100%",
    },
    basic: {
        fontFamily: "BMDOHYEON"
    },
    alignCenter: {
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
    },
    title: {
        width: "100%",
        height: 100,
        marginTop: 30,
        fontSize: 30,
    },
    score: {
        width: "100%",
        height: 300,
        fontSize: 50,
    },
    description: {
        width: "100%",
        height: 30,
        fontSize: 20
    }
};

class Landing extends Component {
    score;

    constructor(props) {
        super(props);

        this.score = props.score;
    }

    render() {
        return (
            <div style={style.container}>
                <div style={Object.assign(style.title, style.alignCenter, style.basic)}>아재력 테스트</div>
                <div style={Object.assign(style.description, style.alignCenter, style.basic)}>{this.props.nickName}님의 아재력입니다</div>
                <div style={Object.assign(style.score, style.alignCenter, style.basic)}>{this.score}</div>
                <a href="http://play.google.com/store/apps/details?id=io.harry.doodlenow">link</a>
            </div>
        );
    }

    componentDidMount() {

    }
}

export default Landing;
