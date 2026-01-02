import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useAuth } from './security/AuthContext'


export default function LoginComponent(){

    const [username , setUsername] = useState('Sudeshna')
    const [password , setPassword] = useState('')
    const [showErrorMessage , setShowErrorMessage] = useState(false)
    const navigate = useNavigate() //hook to navigate to a route
    const authContext = useAuth()

    function handleUsername(event){
        setUsername(event.target.value)
    }

    function handlePassword(event){
        setPassword(event.target.value)
    }

    async function handleSubmit(){
       if(await authContext.login(username , password)){
            navigate(`/welcome/${username}`) //navigating to welcome route
       } else {
            setShowErrorMessage(true)
       }
    }

    return(
        <div className="Login">
            <div className="LoginForm">
                <h1>Time to Login</h1>
                {showErrorMessage && <div className="errorMessage">Authentication Failed. Please check your Credentials</div>}
                <div>
                    <label>User Name</label>
                    <input type="text" name="username" value={username} onChange={handleUsername}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePassword}/>
                </div>
                <div>
                    <button type="button" name="Login" onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    )
}

//Controlled Component - Input feild whose value is controlled by React state variable
//Whenever something changes in the input feild , onChange event is fired
//and event handler updates the state variable
//whenever state variable is updated , the feild element is also updated

//Conditional Rendering in React
//true && Anything -> Anything
//false && Anything -> false 

//useNavigate -> Hook to navigate to different route 

//When we store something in state variable of a component
//and navigate to another component , the state variable is lost
//To persist the data across components we can use Context
