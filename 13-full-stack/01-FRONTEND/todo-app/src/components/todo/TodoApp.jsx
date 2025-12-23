import { useState } from 'react'
import './TodoApp.css'
export default function TodoApp() {
    return(
        <div className="TodoApp">
            Todo Management Application
            <LoginComponent/>
            {/* <WelcomeComponent/> */}
        </div>
    )
}

function LoginComponent(){
    const [username , setUsername] = useState('')
    const [password , setPassword] = useState('')

    function handleUsername(event){
        setUsername(event.target.value)
    }
    function handlePassword(event){
        setPassword(event.target.value)
    }

    return(
        <div className="Login">
            <div className="LoginForm">
                <div>
                    <label>User Name</label>
                    <input type="text" name="username" value={username} onChange={handleUsername}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePassword}/>
                </div>
                <div>
                    <button type="button" name="Login">Login</button>
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