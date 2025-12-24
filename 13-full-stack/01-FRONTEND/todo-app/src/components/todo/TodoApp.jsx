import { BrowserRouter , Routes , Route} from 'react-router-dom'
import LogoutComponent from './LogoutComponent.jsx'
import HeaderComponent from './HeaderComponent.jsx'
import ListTodosComponent from './ListTodosComponent.jsx'
import ErrorComponent from './ErrorComponent.jsx'
import WelcomeComponent from './WelcomeComponent.jsx'
import LoginComponent from './LoginComponent.jsx'
import './TodoApp.css'

export default function TodoApp() {

    return(
        <div className="TodoApp">

            <BrowserRouter>
                <HeaderComponent/>
                <Routes>
                    <Route path='/' element={<LoginComponent/>} />
                    <Route path='/login' element={<LoginComponent/>} />
                    <Route path='/welcome/:username' element={<WelcomeComponent/>} />
                    <Route path='/todos' element={<ListTodosComponent/>} />
                    <Route path='/logout' element={<LogoutComponent/>} />
                    <Route path='*' element={<ErrorComponent/>} />
                </Routes>
            </BrowserRouter>  

        </div>
    )
}


//React Router Dom ~ Library to handle routing in React Application
//BrowserRouter -> Routes -> Route





