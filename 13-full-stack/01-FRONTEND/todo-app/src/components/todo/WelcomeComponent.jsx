import axios from 'axios'
import {useParams, Link } from 'react-router-dom'

export default function WelcomeComponent(){

    const {username} = useParams() //hook to get path variables, object is destructured to get username
    
    function callHelloWorldRestAPI(){
        console.log("called")
        //axios to call REST API
        axios.get('http://localhost:8080/hello-world')          //Returns a Promise on a GET request to the specified URL
             .then((response) => successfulResponse(response))  //Callback for successful response
             .catch((error) => errorResponse(error))            //Callback for error response
             .finally(() => console.log('cleanup'))             //Callback for cleanup activity ~ always executed
    }

    function successfulResponse(response){
        console.log(response)
    }

    function errorResponse(error){
        console.log(error)
    }

    return(
        <div className="WelcomeComponent">
            <h1>Welcome {username}</h1>
            <div>
                Manage your Todos <Link to="/todos">here</Link>
            </div>
            <div>
                <button className="btn btn-success m-5" onClick={callHelloWorldRestAPI}>Call Hello World</button>
            </div>
        </div>
    )
}

//useParams -> Hook to get path variables from the URL

//Link -> Component to navigate to different route without reloading the entire page in SPA
//Link can only be used for components inside BrowserRouter

