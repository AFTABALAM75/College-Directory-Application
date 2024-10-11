// Login.js
import React, { useState } from 'react';
import axios from 'axios';

function Login(props) {
    const [formData, setFormData] = useState({
        username: '',
        password: '',
        role: 'STUDENT'
    });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('/api/auth/login', formData)
            .then(response => {
                localStorage.setItem('token', response.data.token);
                props.history.push(`/${formData.role.toLowerCase()}`);
            })
            .catch(error => {
                console.error('Login error', error);
                alert('Invalid credentials');
            });
    };

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" name="username" placeholder="Username"
                    value={formData.username} onChange={handleChange} required />
                <input type="password" name="password" placeholder="Password"
                    value={formData.password} onChange={handleChange} required />
                <select name="role" value={formData.role} onChange={handleChange}>
                    <option value="STUDENT">Student</option>
                    <option value="FACULTY_MEMBER">Faculty Member</option>
                    <option value="ADMINISTRATOR">Administrator</option>
                </select>
                <button type="submit">Login</button>
            </form>
        </div>
    );
}

export default Login;
