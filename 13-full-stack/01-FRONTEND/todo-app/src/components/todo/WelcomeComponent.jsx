import {useParams, Link } from 'react-router-dom'

export default function WelcomeComponent(){

    const {username} = useParams() //hook to get path variables, object is destructured to get username
    
    return(
        <div className="WelcomeComponent">
            <h1>Welcome {username}</h1>
            <div>
                Manage your Todos <Link to="/todos">here</Link>
            </div>
        </div>
    )
}

//useParams -> Hook to get path variables from the URL

//Link -> Component to navigate to different route without reloading the entire page in SPA
//Link can only be used for components inside BrowserRouter

