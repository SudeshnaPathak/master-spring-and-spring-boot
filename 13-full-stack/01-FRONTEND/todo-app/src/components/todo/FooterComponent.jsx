import { useAuth } from "./security/AuthContext"

export default function FooterComponent(){

    const authContext = useAuth()
    console.log(`Footer Component: ${authContext.number}`)

    return(
        <footer className="Footer">
            <div className="container">
                Footer
            </div>
        </footer>
    )
}