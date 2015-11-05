-- This SQL script is automatically injected into the application database upon startup by the Hibernate
-- library. Intended for development purposes only, this feature can be disabled by removing the 
-- line for 'spring.jpa.hibernate.ddl-auto' in application.properties.

insert into project(name, description) VALUES ("chinaweb", "IHG China Web Application");
insert into project(name, description) VALUES ("mobileweb", "IHG Global Mobile Web Application");

insert into test_group(name, description, project) VALUES("smoke-tests", "Smoke tests for the application", 1);
insert into test_group(name, description, project) VALUES("payment-tests", "Payment tests", 1);
insert into test_group(name, description, project) VALUES("redirect-tests", "Redirect tests", 1);
insert into test_group(name, description, project) VALUES("misc-tests", "Miscallenous", 2);

insert into test_case(name, description, project, test_group) VALUES ("smoke-test-1", "Booking Flow smoke test 1", 1, 1);
insert into test_case(name, description, project, test_group) VALUES ("smoke-test-2", "Booking Flow smoke test 2", 1, 1);
insert into test_case(name, description, project, test_group) VALUES ("smoke-test-3", "Booking Flow smoke test 3", 1, 1);
insert into test_case(name, description, project, test_group) VALUES ("smoke-test-cc-1", "Booking Flow smoke test with credit card 1", 1, 2);
insert into test_case(name, description, project, test_group) VALUES ("smoke-test-cc-2", "Booking Flow smoke test with credit card 2", 1, 2);
insert into test_case(name, description, project, test_group) VALUES ("redirect-to-mobile", "Checks to make sure chinaweb redirects mobile traffic to the mobileweb project", 1, 3);

insert into test_case(name, description, project, test_group) VALUES ("smoke-test-1", "Booking Flow smoke test 1", 2, 4);
insert into test_case(name, description, project, test_group) VALUES ("smoke-test-2", "Booking Flow smoke test 2", 2, 4);
insert into test_case(name, description, project, test_group) VALUES ("smoke-test-cc-1", "Booking Flow smoke test with credit card 1", 2, 4);