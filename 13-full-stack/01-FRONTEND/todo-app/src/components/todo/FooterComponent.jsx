import { useContext } from "react"
import { AuthContext } from "./security/AuthContext"

export default function FooterComponent(){

    const authContext = useContext(AuthContext) //hook to consume the context
    console.log(`Footer Component: ${authContext.number}`)

    return(
        <footer className="Footer">
            <div className="container">
                Footer
            </div>
        </footer>
    )
}