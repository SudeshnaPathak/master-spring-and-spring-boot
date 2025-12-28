import axios from 'axios'

// export function retrieveHelloWorldBean(){
//      //axios to call REST API
//     return axios.get('http://localhost:8080/hello-world-bean') //Returns a Promise on GET request to the specified URL
// }

export const retrieveHelloWorldBean = () => axios.get('http://localhost:8080/hello-world-bean')