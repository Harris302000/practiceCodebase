import React from "react";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Badge from 'react-bootstrap/Badge';

const Skills = () => {

  let logo = (categ) => {
    console.log("categ::"+categ);
    
    switch (categ) {
      case 'Backend':
        
        return <span>⚙️ Backend</span>;
      case 'Frontend':
        
        return <span>⚛️ Frontend</span>;
      case 'Database':
        
        return <span>🗄️ Database</span>;
      
      case 'Tools_And_Platforms':
        
        return <span>🛠️ Tools & Platforms</span>;
    
      default:
        break;
    }


  }


  const skills = {
    Backend: ["Java", "Spring Boot", "REST APIs", "Microservices"],

    Frontend: ["React.js", "JavaScript", "HTML5", "CSS3"],

    Database: ["Oracle", "MySQL", "PostgreSQL"],

    Tools_And_Platforms: ["Git", "Jenkins", "Postman"],
  };

  return (
    <div className="Skills-Div  body-bg">
      <section>
        <center>
          <h1 style={{ padding: "20px 60px" }}>Skills & Technologies</h1>
          <p className="pb-[40px]">Technologies and tools I use to build reliable,
             scalable applications.</p>
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
                  <Card
                    className="w-[100%] md:w-[50%] underline !bg-[#1E293B] hover:scale-105 transition-all duration-500"
                    key={index}
                  >
                    <Card.Body>
                      <Card.Title className="text-white pb-[20px] m-0">
                        {logo(category)}
                      </Card.Title>

                      {skillset.map((skill) => {
                        return (
                          <Card.Text>
                            <Badge className="w-[70%] !bg-blue-900  hover:scale-110 hover:!bg-blue-600 !px-4 !py-2 !rounded-full">
                              📖 {skill}
                            </Badge>
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
