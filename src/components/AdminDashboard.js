// AdminDashboard.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function AdminDashboard() {
    const [users, setUsers] = useState([]);
    const [dashboardData, setDashboardData] = useState(null);

    useEffect(() => {
        axios.get('/api/admin/users', {
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            }
        })
            .then(response => {
                setUsers(response.data);
                return axios.get('/api/admin/dashboard', {
                    headers: {
                        'Authorization': `Bearer ${localStorage.getItem('token')}`
                    }
                });
            })
            .then(response => {
                setDashboardData(response.data);
            })
            .catch(error => {
                console.error('Error fetching data', error);
            });
    }, []);

    return (
        <div>
            <h2>Administrator Dashboard</h2>
            <h3>Manage Users</h3>
            <ul>
                {users.map(user => (
                    <li key={user.id}>
                        {user.name} - {user.role}
                        {/* Add options to edit or delete user */}
                    </li>
                ))}
            </ul>

            <h3>Dashboard Data</h3>
            {/* Use a chart library like Chart.js or Recharts to display graphs */}
            {/* Example: <Chart data={dashboardData} /> */}
        </div>
    );
}

export default AdminDashboard;
