const Pool = require('pg').Pool
const pool = new Pool({
    user: 'postgres',
    host: 'localhost',
    database: 'sprint2',
    password: 'password',
    port: 5432
})


const get_route = (request, response) => {
    pool.query('SELECT route_name FROM public."site_routes"', (error, results) => {
        if (error){
            throw error;
        }
        response.status(200).json(results.rows)
    })
}

const get_role = (request, response) => {
    pool.query('SELECT role_name, description FROM public."user_roles"', (error, results) => {
        if (error){
            throw error;
        }
        response.status(200).json(results.rows)
    })
}

const get_route_and_role = (request, response) => {
    const role = request.params.role
    pool.query('SELECT route_name FROM public."roles_and_their_routes" WHERE role_name = $1', [role], (error,results) => {
        if (error){
            throw error;
        }
        response.status(200).json(results.rows)
    })
}

module.exports ={
    get_role,
    get_route,
    get_route_and_role
};