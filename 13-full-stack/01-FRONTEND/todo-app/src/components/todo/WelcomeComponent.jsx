import { useState } from 'react'
import {useParams, Link } from 'react-router-dom'
import {retrieveHelloWorldPathVariable} from './api/HelloWorldApiService';

export default function WelcomeComponent(){

    const {username} = useParams() //hook to get path variables, object is destructured to get username
    const [message , setMessage] = useState(null);
    
    function callHelloWorldRestAPI(){

        console.log("called")        

        retrieveHelloWorldPathVariable(username)              //Returns a Promise
        .then((response) => successfulResponse(response))     //Callback for successful response
        .catch((error) => errorResponse(error))               //Callback for error response
        .finally(() => console.log('cleanup'))                //Callback for cleanup activity ~ always executed
    }

    function successfulResponse(response){
        console.log(response)
        setMessage(response.data.message)
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
            <div className="text-info">{message}</div>
        </div>
    )
}

//useParams -> Hook to get path variables from the URL

//Link -> Component to navigate to different route without reloading the entire page in SPA
//Link can only be used for components inside BrowserRouter

