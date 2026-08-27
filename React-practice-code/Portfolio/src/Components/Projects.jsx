import React from 'react'
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

const Projects = () => {

    let buttons = (<div style={{display:'flex',gap : '20px'}}>
                <Button variant="primary">View Project</Button>
                <Button variant="primary">Github</Button>
            </div>);

  return (
    <div className="Projects-Div body-bg">
      <center>
        <h1 style={{ padding: "60px" }}>Projects</h1>
      </center>

      <div style={{ display: "flex", flexDirection: "column", gap: "20px" }}>
        <Card>
          <Card.Header>
            <Card.Title>Loan Origination System</Card.Title>
          </Card.Header>
          <Card.Body style={{ padding: "15px 30px" }}>
            <Card.Subtitle>Description:</Card.Subtitle>
            <Card.Text>
              An enterprise loan origination application designed to support
              end-to-end lending workflows, from application initiation through
              processing and approval.
            </Card.Text>
            <Card.Subtitle>Technologies Used:</Card.Subtitle>
            <Card.Text>
              Java, Spring Boot, REST APIs, SOAP, SQL, BPMN, OmniApp
            </Card.Text>
            <Card.Subtitle>Role / Contribution:</Card.Subtitle>
            <Card.Text>
              Developed and maintained backend functionality, implemented
              business requirements, integrated APIs, worked with database
              operations, and collaborated with BA and QA teams.
            </Card.Text>
            {/* {buttons} */}
          </Card.Body>
        </Card>

        <Card>
          <Card.Header>
            <Card.Title>BMI Calculator</Card.Title>
          </Card.Header>
          <Card.Body style={{ padding: "15px 30px" }}>
            <Card.Subtitle>Description:</Card.Subtitle>
            <Card.Text>
              A responsive web application that calculates a user's BMI based on
              height and weight and displays the corresponding BMI category.
            </Card.Text>
            <Card.Subtitle>Technologies Used:</Card.Subtitle>
            <Card.Text>React.js, JavaScript, HTML5, CSS3</Card.Text>
            <Card.Subtitle>Role / Contribution:</Card.Subtitle>
            <Card.Text>
              Designed and developed the application, implemented BMI
              calculation logic, handled user input and validation, and created
              the responsive UI using React components and state management.
            </Card.Text>
            {/* {buttons} */}
          </Card.Body>
        </Card>

        <Card>
          <Card.Header>
            <Card.Title>To Do Application</Card.Title>
          </Card.Header>
          <Card.Body style={{ padding: "15px 30px" }}>
            <Card.Subtitle>Description:</Card.Subtitle>
            <Card.Text>
              A full-stack task management application that allows users to add,
              edit, delete, and mark tasks as completed, with task data
              persistently stored in a backend database.
            </Card.Text>
            <Card.Subtitle>Technologies Used:</Card.Subtitle>
            <Card.Text>
              React.js, JavaScript, HTML5, CSS3, Spring Boot, REST APIs,
              JPA/Hibernate, PostgreSQL
            </Card.Text>
            <Card.Subtitle>Role / Contribution:</Card.Subtitle>
            <Card.Text>
              Developed the React.js frontend and Spring Boot backend,
              implemented REST APIs for CRUD operations, integrated the frontend
              with the backend, and used JPA/Hibernate to persist task data in
              the database.
            </Card.Text>
            {/* {buttons} */}
          </Card.Body>
        </Card>

        <Card>
          <Card.Header>
            <Card.Title>Calculator Application</Card.Title>
          </Card.Header>
          <Card.Body style={{ padding: "15px 30px" }}>
            <Card.Subtitle>Description:</Card.Subtitle>
            <Card.Text>
              A simple calculator application that performs basic arithmetic
              operations such as addition, subtraction, multiplication, and
              division.
            </Card.Text>
            <Card.Subtitle>Technologies Used:</Card.Subtitle>
            <Card.Text>HTML5, CSS3, JavaScript</Card.Text>
            <Card.Subtitle>Role / Contribution:</Card.Subtitle>
            <Card.Text>
              Designed and developed the calculator interface, implemented
              arithmetic operations using JavaScript, and handled user
              interactions and input dynamically.
            </Card.Text>
            {/* {buttons} */}
          </Card.Body>
        </Card>

        <Card>
          <Card.Header>
            <Card.Title>E-Commerce Application</Card.Title>
          </Card.Header>
          <Card.Body style={{ padding: "15px 30px" }}>
            <Card.Subtitle>Description:</Card.Subtitle>
            <Card.Text>
              A full-stack e-commerce application designed with a multi-page
              user flow, starting with a welcome page, followed by user login
              and signup, and an introduction page before accessing the main
              application features.
            </Card.Text>
            <Card.Subtitle>Technologies Used:</Card.Subtitle>
            <Card.Text>
              React.js, JavaScript, HTML5, CSS3, Spring Boot, REST APIs,
              JPA/Hibernate, PostgreSQL
            </Card.Text>
            <Card.Subtitle>Role / Contribution:</Card.Subtitle>
            <Card.Text>
              Developed the frontend user flow including the welcome, login,
              signup, and introduction pages. Implemented the Spring Boot
              backend and REST APIs, integrated frontend and backend services,
              and handled user and application data persistence using
              JPA/Hibernate and PostgreSQL.
            </Card.Text>
            {/* {buttons} */}
          </Card.Body>
        </Card>
      </div>
    </div>
  );
}

export default Projects