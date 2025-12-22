# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

### `npm install --save <package_name>`

Installs a new package and saves it as a dependency in the `package.json` file.

### `npx create-react-app my-app` 

Runs the create-react-app command to set up a new React project called "my-app".

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.
Automatically builds the app and renders it in the browser in case of code changes.\

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Run unit tests.
Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production, a production deployable unit to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**

If you aren't satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you're on your own.

You don't have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn't feel obligated to use this feature. However we understand that this tool wouldn't be useful if you couldn't customize it when you are ready for it.

## Create React App Folder Structure

When you create a new React app using Create React App, the project structure looks like this:

1. `README.md` - Documentation file for the project.
2. `package.json` - Contains metadata about the project and dependencies defined.(similar to Maven pom.xml)

3. `node_modules` - Directory where project dependencies are downloaded.(npm downloads packages here)

### React Initialization

1. `public/index.html` - The main HTML file that serves the React application. Contains root div element.

2. `src/index.js` - Populates the root div in index.html with the App component.

        src/index.css - Global CSS styles for the entire application.

3. `src/App.js` - Code for the App component, the main component of the application. Rest of the components are created as child components of App component.

        src/App.css - CSS styles specific to the App component.
        src/App.test.js - Unit Tests for the App component.


## Why do we need React Components?

Create separate components for each Page Element: Menu Component, Footer Component, Header Component, Login Component, Logout Component etc.
This helps in Code modularisation and Reusability.React components always start with a Capital letter.

### App Component

The First Component that gets loaded when React Application starts. The rest of the components are created as the child components of App Component.

### Parts of a React Component

1. View - JSX or JavaScript XML to describe the UI structure of a React component.
2. Logic - JavaScript code to define the component behaviour.
3. Styles - CSS to define the styling of the component.
4. State - Built-in React object to hold data that may change over the lifetime of the component.
5. Props - To pass data from one component to another component.

### Hooks and Component Naming Conventions
1. Hooks(useState) can be used to add state to functional components.
2. lowercase tag names refer to HTML elements.
3. Uppercase Component names refer to user-defined components.

## JSX Views with React

1. React projects use JSX (JavaScript XML) to define the View part of a React component.
2. JSX is stricter than HTML.
3. JSX tags must be properly closed.
4. JSX expressions must have only one parent element. JSX allows only one top-level tag to be returned from a component.
5. Babel transpiler converts JSX to plain JavaScript before executing it in the browser.

## React Dev Tools
You can install React Developer Tools as a browser extension for Chrome, Firefox or Edge. It allows you to inspect the React component hierarchy of how they are rendered, view component props, state, source file, and debug React applications more effectively.

## HTML vs React DOM Manipulation:

### HTML
In HTML, A HTML page is represented as a DOM (Document Object Model) tree structure. Each element in HTML is a node in the DOM. We need to update the DOM to update in the UI. But updating the DOM is an expensive operation.

### React
React uses a Virtual DOM(kept in memory) which is a lightweight copy of the actual DOM. When the state of a component changes, React updates the Virtual DOM first. It then compares the updated Virtual DOM with the previous version of the Virtual DOM to find out what has changed. Finally, it updates only those parts of the actual DOM that have changed. This process is called Reconciliation and it makes React very efficient.We are not directly manipulating the DOM, instead we are updating the state and React identifies the changes and updates the DOM accordingly.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: [https://facebook.github.io/create-react-app/docs/code-splitting](https://facebook.github.io/create-react-app/docs/code-splitting)

### Analyzing the Bundle Size

This section has moved here: [https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size](https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size)

### Making a Progressive Web App

This section has moved here: [https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app](https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app)

### Advanced Configuration

This section has moved here: [https://facebook.github.io/create-react-app/docs/advanced-configuration](https://facebook.github.io/create-react-app/docs/advanced-configuration)

### Deployment

This section has moved here: [https://facebook.github.io/create-react-app/docs/deployment](https://facebook.github.io/create-react-app/docs/deployment)

### `npm run build` fails to minify

This section has moved here: [https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify](https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify)
