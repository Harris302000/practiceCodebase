import React from "react";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Badge from 'react-bootstrap/Badge';

const Skills = () => {
  const skills = {
    Backend: ["Java", "Spring Boot", "REST APIs", "Microservices"],

    Frontend: ["React.js", "JavaScript", "HTML5", "CSS3"],

    Database: ["Oracle", "MySQL", "PostgreSQL"],

    Tools_And_Platforms: ["Git", "Jenkins", "Postman"],
  };

  return (
    <div className="Skills-Div h-[92vh] body-bg">
      <section>
        <center>
          <h1 style={{ padding: "60px" }}>Skills & Technologies</h1>

          <div
            style={{
              width: "70%",
              display: "grid",
              // gridTemplateColumns: 'repeat(2, 1fr)',
              gap: "20px",
              justifyContent: "center",
              alignItems : 'center'
            }}

            className="grid-cols-1 md:grid-cols-2"
          >
            {Object.entries(skills).map(([category, skillset], index) => {
              return (
                <div className="flex justify-center">
                  <Card className="w-[100%] md:w-[50%] underline" key={index}>
                  <Card.Body>
                    <Card.Title>
                      {category.replaceAll("_", " ").replace("And", "&")}
                    </Card.Title>

                    {skillset.map((skill) => {
                      return (
                        <Card.Text>
                          <Badge className="w-[45%] !bg-blue-900">{skill}</Badge>
                        </Card.Text>
                      );
                    })}
                  </Card.Body>
                </Card>
                </div>
                
              );
            })}
          </div>
        </center>
      </section>
    </div>
  );
};

export default Skills;
