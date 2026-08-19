import React from 'react'
import Accordion from 'react-bootstrap/Accordion'

const Experience = () => {
  return (
    <div className="Expirence-Div">
      <center>
        <h1 style={{ padding: "60px" }}>Experience</h1>
      </center>

      <Accordion defaultActiveKey="">
        <Accordion.Item eventKey="0">
          <Accordion.Header>
            Newgen Software Technologies Limited (Apr 2022 - Aug 2026)
          </Accordion.Header>
          <Accordion.Body>
            <b>Role:</b> Java Developer
          </Accordion.Body>
          <Accordion.Body>
            <b>Experience:</b> 4+ Years
          </Accordion.Body>
          <Accordion.Body>
            As a Java Developer, I am responsible for developing and maintaining
            enterprise-level backend applications using Core Java and Spring
            Boot. I work on implementing business requirements, developing
            backend services, and building REST APIs to support application
            workflows and system integrations.
          </Accordion.Body>
          <Accordion.Body>
            My experience includes working with REST and SOAP integrations,
            developing and executing SQL queries, and performing
            database-related operations using relational databases. I have
            primarily worked on Loan Origination Systems (LOS) in the BFSI
            domain, supporting lending workflows and ensuring smooth end-to-end
            processing.
          </Accordion.Body>
          <Accordion.Body>
            I have worked with OmniApp and BPMN-based workflows to implement
            application processes and validations. I also collaborate closely
            with Business Analysts and QA teams to understand requirements,
            resolve functional issues, perform testing support, and ensure the
            application meets business and quality requirements.
          </Accordion.Body>
        </Accordion.Item>

      </Accordion>
    </div>
  );
}

export default Experience