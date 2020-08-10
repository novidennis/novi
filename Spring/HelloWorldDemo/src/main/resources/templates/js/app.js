const React = require('react');
const ReactDOM = require('react-dom');
const axios = require('axios');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {student: {}};
    }

    componentDidMount() {
        axios.get('/api/student').then(result => {
            this.setState({student: result.data});
        });
    }

    render() {
        return (<div>
                <h1> Hello {this.state.student.name}</h1>
            </div>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)