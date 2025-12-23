import { useState } from 'react'
import './TodoApp.css'
export default function TodoApp() {
    return(
        <div className="TodoApp">
            <LoginComponent/>
            {/* <WelcomeComponent/> */}
        </div>
    )
}

function LoginComponent(){
    const [username , setUsername] = useState('in28minutes')
    const [password , setPassword] = useState('')
    const [showSuccessMessage , setShowSuccessMessage] = useState(false)
    const [showErrorMessage , setShowErrorMessage] = useState(false)

    function handleUsername(event){
        setUsername(event.target.value)
    }

    function handlePassword(event){
        setPassword(event.target.value)
    }

    function handleSubmit(){
       if(username==='in28minutes' && password==='dummy'){
            setShowSuccessMessage(true)
            setShowErrorMessage(false)
       } else {
            setShowSuccessMessage(false)
            setShowErrorMessage(true)
       }
    }

    function SuccessMessageComponent(){
        if(showSuccessMessage)
            return <div>Authenticated Successfully</div>
        return null
        }

    function ErrorMessageComponent(){
        if(showErrorMessage)
            return <div>Authentication Failed. Please check your Credentials</div>
        return null
    }

    return(
        <div className="Login">
            <div className="LoginForm">
                <SuccessMessageComponent/>
                <ErrorMessageComponent/>
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

// function WelcomeComponent(){
//     return(
//         <div className="Welcome">
//             Welcome Component
//         </div>
//     )
// }