import React from "react";
import Button from "react-bootstrap/Button";
import img1 from "../assets/Images/Harris_IMG.JPG";
import {Link} from "react-router-dom";

const Home = () => {
  return (
    <div className="Home-Div">
      <section>
        <div style={{ width: "70%",height : '80vh',display:'flex',flexDirection:'column',justifyContent:'center',alignItems:'center'}}>
          <h2>Hi, I'm Agnes Harris Fernando</h2>
          <h4>Java Full Stack Developer</h4>
          <p style={{width : '70%',padding: '40px 0px', fontSize : '18px'}}>
            I’m a Java Developer with 4+ years of experience, primarily in the
            banking domain. I have strong experience in Core Java, Spring Boot,
            REST APIs, SQL, and microservices, and I’ve worked on Loan
            Origination Systems involving end-to-end application development and
            integration. I also have working knowledge of React.js and
            experience collaborating with clients, business analysts, and QA
            teams.
          </p>
          <div
            style={{
              display: "flex",
              justifyContent: "space-between",
              width: "300px",
            }}
          >
            <Button  as={Link} to={"/projects"} variant="primary">View My Projects</Button>
            <Button  as={Link} to={"/contact"} variant="primary">Contact Me</Button>
          </div>
        </div>

        <div style={{flex:'1'}}>
            <img src={img1} alt="Image not found" />
          </div>
      </section>
    </div>
  );
};

export default Home;
