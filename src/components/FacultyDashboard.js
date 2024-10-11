// FacultyDashboard.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function FacultyDashboard() {
    const [profile, setProfile] = useState(null);
    const [classList, setClassList] = useState([]);

    useEffect(() => {
        axios.get('/api/faculty/profile', {
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            }
        })
            .then(response => {
                setProfile(response.data);
                // Fetch class list
                return axios.get('/api/faculty/classes', {
                    headers: {
                        'Authorization': `Bearer ${localStorage.getItem('token')}`
                    }
                });
            })
            .then(response => {
                setClassList(response.data);
            })
            .catch(error => {
                console.error('Error fetching data', error);
            });
    }, []);

    if (!profile) return <div>Loading...</div>;

    return (
        <div>
            <h2>Welcome, {profile.user.name}</h2>
            <img src={profile.photo} alt="Profile" />
            <p>Email: {profile.user.email}</p>
            <p>Phone: {profile.user.phone}</p>
            <p>Department: {profile.department.name}</p>
            <p>Office Hours: {profile.officeHours}</p>

            <h3>Class List</h3>
            <ul>
                {classList.map(student => (
                    <li key={student.id}>
                        {student.name} - {student.email}
                    </li>
                ))}
            </ul>

            {/* Add form to update profile */}
        </div>
    );
}

export default FacultyDashboard;
