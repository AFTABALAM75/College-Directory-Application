// StudentDashboard.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function StudentDashboard() {
    const [profile, setProfile] = useState(null);

    useEffect(() => {
        axios.get('/api/student/profile', {
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            }
        })
            .then(response => {
                setProfile(response.data);
            })
            .catch(error => {
                console.error('Error fetching profile', error);
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
            <p>Year: {profile.year}</p>
            {/* Add components for searching students, contacting faculty */}
        </div>
    );
}

export default StudentDashboard;
