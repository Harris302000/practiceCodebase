import React from 'react'
import Button from "react-bootstrap/Button";

const About = () => {
  return (
    <div className="About-Div body-bg">
      <section className='pt-[60px]'>
        {/* <h1 style={{ padding: "60px" }}>About Me</h1> */}

        <div className="flex flex-col md:flex-row gap-[20px]">
          <div className="w-[100%] md:w-[65%] border-2 border-blue-950 rounded-2xl  ">
            <center>
              <h5 className="pt-3 m-0">Professional Summary</h5>
            </center>

            <p>
              I am a Java Developer with 4+ years of experience in designing,
              developing, and maintaining enterprise applications, primarily
              using Core Java, Spring Boot, REST APIs, SQL, and microservices. I
              have strong experience in backend development, database
              operations, API integration, and implementing business
              requirements in scalable Java-based applications.
            </p>
            <p>
              I have primarily worked in the BFSI (Banking, Financial Services,
              and Insurance) domain, contributing to Loan Origination Systems
              (LOS) for different lending processes, including agriculture,
              MSME, and vehicle loans. My experience includes working with
              OmniApp, BPMN workflows, REST and SOAP integrations, and
              collaborating with clients, Business Analysts, and QA teams to
              ensure smooth end-to-end application workflows.
            </p>
            <p>
              Along with my backend expertise, I am actively expanding my
              frontend development skills with React.js, including components,
              React Bootstrap, state management, API integration, and responsive
              UI development. My goal is to strengthen my full-stack
              capabilities by combining my Java backend experience with modern
              frontend technologies.
            </p>
          </div>

          <div
            style={{ flex: "1", padding: "20px 40px" }}
            className="border-2 border-blue-950 rounded-2xl"
          >
            <center>
              <h5>Professional highlights</h5>
            </center>

            <ul id='pro-highlights-li'
              style={{
                display: "flex",
                flexDirection: "column",
                padding: "10px 40px",
                gap: "10px",
              }}
            >
              <li>⚡ 4+ Years Experience</li>
              <li>☕ Java & Spring Boot</li>
              <li>⚛️ React.js</li>
              <li>🏦 BFSI / Banking Domain</li>
              <li>🔗 REST APIs & Microservices</li>
              <li>🗄️ SQL & Database</li>
            </ul>
          </div>
        </div>
        <Button
          variant="primary"
          style={{ margin: "30px 0px" }}
          className="transition-all hover:scale-105 hover:shadow-lg"
        >
          Download Resume
        </Button>
      </section>
    </div>
  );
}

export default About