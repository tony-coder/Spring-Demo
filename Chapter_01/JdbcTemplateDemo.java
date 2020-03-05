/**
* Spring 的JdbcTemplate 例子
*/

public JdbcTemplateDemo {

	public Employee getEmployeeById(long id) {
		return jdbcTemplate.queryForObject(
		    "select id,firstname,lastname,salary" +
		    "from employee where id=?",
		new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setFirstName(rs.getString("firstname"));
				employee.setLastNmae(rs.getString("lastname"));
				employee.setSalary(rs.getBigDecimal("salary"));
				return employee;
			}
		},
		id);  //指定查询参数
	}
}