// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './components/Login';
import StudentDashboard from './components/StudentDashboard';
import FacultyDashboard from './components/FacultyDashboard';
import AdminDashboard from './components/AdminDashboard';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" exact component={Login} />
                <Route path="/student" component={StudentDashboard} />
                <Route path="/faculty_member" component={FacultyDashboard} />
                <Route path="/administrator" component={AdminDashboard} />
                {/* Add protected routes and redirects as needed */}
            </Routes>
        </Router>
    );
}

export default App;
