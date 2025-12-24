import { useState } from 'react'
import { BrowserRouter , Routes , Route , useNavigate , useParams, Link } from 'react-router-dom'
import './TodoApp.css'
export default function TodoApp() {

    return(
        <div className="TodoApp">
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<LoginComponent/>} />
                    <Route path='/login' element={<LoginComponent/>} />
                    <Route path='/welcome/:username' element={<WelcomeComponent/>} />
                    <Route path='/todos' element={<ListTodosComponent/>} />
                    <Route path='*' element={<ErrorComponent/>} />
                </Routes>
            </BrowserRouter>            
        </div>
    )
}

function LoginComponent(){

    const [username , setUsername] = useState('in28minutes')
    const [password , setPassword] = useState('')
    const [showSuccessMessage , setShowSuccessMessage] = useState(false)
    const [showErrorMessage , setShowErrorMessage] = useState(false)
    const navigate = useNavigate() //hook to navigate to a route

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
            navigate(`/welcome/${username}`) //navigating to welcome route
       } else {
            setShowSuccessMessage(false)
            setShowErrorMessage(true)
       }
    }

    return(
        <div className="Login">
            <div className="LoginForm">
                <h1>Time to Login</h1>
                {showSuccessMessage && <div className="successMessage">Authenticated Successfully</div>}
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

function WelcomeComponent(){

    const {username} = useParams() //hook to get path variables , object is destructured to get username
    
    return(
        <div className="WelcomeComponent">
            <h1>Welcome {username}</h1>
            <div>
                Manage your Todos <Link to="/todos">here</Link>
            </div>
        </div>
    )
}

function ErrorComponent(){

    return(
        <div className="ErrorComponent">
           <h1>We are working really hard!</h1>
           <div>Appologies for 404. Reach out to our team at ABC-DEF-GHI</div>
        </div>
    )
}

function ListTodosComponent(){

    const today = new Date()
    const targetDate = new Date(today.getFullYear()+12 , today.getMonth() , today.getDay())
    const todos = [
                    {id : 1 , description : 'Learn AWS' , done : false , targetDate : targetDate},
                    {id : 2 , description : 'Learn DevOps', done : false , targetDate : targetDate},
                    {id : 3 , description : 'Learn Full Stack Development' , done : false , targetDate : targetDate}
                  ]

    return(
        <div className="ListTodosComponent">
           <h1>Things You want to Do!</h1>
           <div>
                <table>
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Description</td>
                            <td>Is Done?</td>
                            <td>Target Date</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(
                                todo =>(
                                    <tr key={todo.id}>
                                        <td>{todo.id}</td>
                                        <td>{todo.description}</td>
                                        <td>{todo.done.toString()}</td>
                                        <td>{todo.targetDate.toDateString()}</td>
                                    </tr>
                                )
                            )
                        }  
                    </tbody>
                </table>
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

//React Router Dom ~ Library to handle routing in React Application
//BrowserRouter -> Routes -> Route
//useNavigate -> Hook to navigate to different route 

//useParams -> Hook to get path variables from the URL

//Link -> Component to navigate to different route without reloading the entire page in SPA



