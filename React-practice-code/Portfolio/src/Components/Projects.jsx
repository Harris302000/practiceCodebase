import React from 'react'
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

const Projects = () => {

    const BMI_CAL = 'BMI-Calculator'
    const CALCULATOR = 'Calculator'
    const E_COMM = 'E-Commerce Application'
    const TODO_APP = 'To Do Application'


    let openApplication =  (app) => {      
      switch (app) {
        case BMI_CAL:
            window.open('https://harrisfdo-bmi-calculator.vercel.app/', '_blank');
        break;

        case CALCULATOR:
            window.open('https://harrisfdo-calculator.vercel.app/', '_blank');
        break;

        case E_COMM:
            window.open('https://harrisfdo-e-commerce.vercel.app/', '_blank');
        break;

        case TODO_APP:
            window.open('https://harrisfdo-todo-app.vercel.app/', '_blank');
        break;
      
        default:
          break;
      }

    }


    let buttons = (application) => {  return (<div style={{display:'flex',gap : '20px'}}>
                <Button variant="primary" onClick={() => openApplication(application)}>View Project</Button>
                {/* <Button variant="primary">Github</Button> */}
            </div>)};

    // let buttons = (<div style={{display:'flex',gap : '20px'}}>
    //             <Button variant="primary" >View Project</Button>
    //             {/* <Button variant="primary">Github</Button> */}
    //         </div>);

    // let buttons = (<div></div>);

  return (
    <div className="Projects-Div body-bg">
      <section className='pt-[60px]'>
        {/* <center>
          <h1 style={{ padding: "60px" }}>Projects</h1>
        </center> */}

        <div style={{ display: "flex", flexDirection: "column", gap: "20px" }}>
          <Card>
            <Card.Header className="!bg-[#1a2c49] !text-[#6366F1] !border-b-white">
              <Card.Title>Loan Origination System</Card.Title>
            </Card.Header>
            <Card.Body
              style={{ padding: "15px 30px" }}
              className="bg-[#1E293B]"
            >
              <Card.Subtitle className="!text-[#6366F1]">
                Description:
              </Card.Subtitle>
              <Card.Text>
                An enterprise loan origination application designed to support
                end-to-end lending workflows, from application initiation
                through processing and approval.
              </Card.Text>
              <Card.Subtitle className="!text-[#6366F1]">
                Technologies Used:
              </Card.Subtitle>
              <Card.Text>
                Java, Spring Boot, REST APIs, SOAP, SQL, BPMN, OmniApp
              </Card.Text>
              <Card.Subtitle className="!text-[#6366F1]">
                Role / Contribution:
              </Card.Subtitle>
              <Card.Text>
                Developed and maintained backend functionality, implemented
                business requirements, integrated APIs, worked with database
                operations, and collaborated with BA and QA teams.
              </Card.Text>
              {/* {buttons} */}
            </Card.Body>
          </Card>

          <Card>
            <Card.Header className="!bg-[#1a2c49] !text-[#6366F1] !border-b-white">
              <Card.Title>BMI Calculator</Card.Title>
            </Card.Header>
            <Card.Body
              style={{ padding: "15px 30px" }}
              className="bg-[#1E293B]"
            >
              <Card.Subtitle className="!text-[#6366F1]">
                Description:
              </Card.Subtitle>
              <Card.Text>
                A responsive web application that calculates a user's BMI based
                on height and weight and displays the corresponding BMI
                category.
              </Card.Text>
              <Card.Subtitle className="!text-[#6366F1]">
                Technologies Used:
              </Card.Subtitle>
              <Card.Text>React.js, JavaScript, HTML5, CSS3</Card.Text>
              <Card.Subtitle className="!text-[#6366F1]">
                Role / Contribution:
              </Card.Subtitle>
              <Card.Text>
                Designed and developed the application, implemented BMI
                calculation logic, handled user input and validation, and
                created the responsive UI using React components and state
                management.
              </Card.Text>
              {buttons(BMI_CAL)}
            </Card.Body>
          </Card>

          <Card>
            <Card.Header className="!bg-[#1a2c49] !text-[#6366F1] !border-b-white">
              <Card.Title>To Do Application</Card.Title>
            </Card.Header>
            <Card.Body
              style={{ padding: "15px 30px" }}
              className="bg-[#1E293B]"
            >
              <Card.Subtitle className="!text-[#6366F1]">
                Description:
              </Card.Subtitle>
              <Card.Text>
                A full-stack task management application that allows users to
                add, edit, delete, and mark tasks as completed, with task data
                persistently stored in a backend database.
              </Card.Text>
              <Card.Subtitle className="!text-[#6366F1]">
                Technologies Used:
              </Card.Subtitle>
              <Card.Text>
                React.js, JavaScript, HTML5, CSS3, Spring Boot, REST APIs,
                JPA/Hibernate, PostgreSQL
              </Card.Text>
              <Card.Subtitle className="!text-[#6366F1]">
                Role / Contribution:
              </Card.Subtitle>
              <Card.Text>
                Developed the React.js frontend and Spring Boot backend,
                implemented REST APIs for CRUD operations, integrated the
                frontend with the backend, and used JPA/Hibernate to persist
                task data in the database.
              </Card.Text>
              {buttons(TODO_APP)}
            </Card.Body>
          </Card>

          <Card>
            <Card.Header className="!bg-[#1a2c49] !text-[#6366F1] !border-b-white">
              <Card.Title>Calculator Application</Card.Title>
            </Card.Header>
            <Card.Body
              style={{ padding: "15px 30px" }}
              className="bg-[#1E293B]"
            >
              <Card.Subtitle className="!text-[#6366F1]">
                Description:
              </Card.Subtitle>
              <Card.Text>
                A simple calculator application that performs basic arithmetic
                operations such as addition, subtraction, multiplication, and
                division.
              </Card.Text>
              <Card.Subtitle className="!text-[#6366F1]">
                Technologies Used:
              </Card.Subtitle>
              <Card.Text>HTML5, CSS3, JavaScript</Card.Text>
              <Card.Subtitle className="!text-[#6366F1]">
                Role / Contribution:
              </Card.Subtitle>
              <Card.Text>
                Designed and developed the calculator interface, implemented
                arithmetic operations using JavaScript, and handled user
                interactions and input dynamically.
              </Card.Text>
              {buttons(CALCULATOR)}
            </Card.Body>
          </Card>

          <Card>
            <Card.Header className="!bg-[#1E293B] !text-[#6366F1] !border-b-white">
              <Card.Title>E-Commerce Application</Card.Title>
            </Card.Header>
            <Card.Body
              style={{ padding: "15px 30px" }}
              className="bg-[#1E293B]"
            >
              <Card.Subtitle className="!text-[#6366F1]">
                Description:
              </Card.Subtitle>
              <Card.Text>
                A full-stack e-commerce application designed with a multi-page
                user flow, starting with a welcome page, followed by user login
                and signup, and an introduction page before accessing the main
                application features.
              </Card.Text>
              <Card.Subtitle className="!text-[#6366F1]">
                Technologies Used:
              </Card.Subtitle>
              <Card.Text>
                React.js, JavaScript, HTML5, CSS3, Spring Boot, REST APIs,
                JPA/Hibernate, PostgreSQL
              </Card.Text>
              <Card.Subtitle className="!text-[#6366F1]">
                Role / Contribution:
              </Card.Subtitle>
              <Card.Text>
                Developed the frontend user flow including the welcome, login,
                signup, and introduction pages. Implemented the Spring Boot
                backend and REST APIs, integrated frontend and backend services,
                and handled user and application data persistence using
                JPA/Hibernate and PostgreSQL.
              </Card.Text>
              {buttons(E_COMM)}
             
            </Card.Body>
          </Card>
        </div>
      </section>
    </div>
  );
}

export default Projects