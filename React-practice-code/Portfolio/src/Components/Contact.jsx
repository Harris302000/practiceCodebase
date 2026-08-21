import React from 'react'
import Card from 'react-bootstrap/Card';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import SendIcon from '@mui/icons-material/Send';
import Swal from 'sweetalert2'

const Contact = () => {

    let handleSubmit = () => {

        Swal.fire({
          title: "Message submitted successfully!",
          icon: "success",
          draggable: false,
        });
    }


  return (
    <div className="Contact-Div body-bg">
      <center>
        <h1 style={{ padding: "60px" }}>Contact Me</h1>
      </center>

      <section>
        <p style={{fontSize: '20px'}}>
          I'm open to opportunities, collaborations, and discussions related to
          Java, Spring Boot, and Full Stack Development.
        </p>

        <Card  className='!border-1 !border-gray-300 !rounded-2xl' style={{ width: "30rem", padding : '10px 40px'}}>
          <Card.Body>
            <center>
                <Card.Title>Contact information</Card.Title>
            </center>
            
            <Card.Text>📧 Email : harrisfernando30@gmail.com</Card.Text>
            <Card.Text>📱 Phone : +91 8526539250</Card.Text>
            <Card.Text>📍 Location : Chennai</Card.Text>
          </Card.Body>
        </Card>

        <Card  className='!border-1 !border-gray-300 !rounded-2xl' style={{ width: "30rem" }}>
          <Card.Body
            style={{ display: "flex", flexDirection: "column", gap: "30px" }}
          >
            <center>
                <Card.Title>Contact form</Card.Title>
            </center>
            
            <TextField id="standard-basic" label="Name" variant="standard" />
            <TextField id="standard-basic" label="Email" variant="standard" />
            <TextField id="standard-basic" label="Subject" variant="standard" />
            <TextField id="standard-basic" label="Message" variant="standard" />
            <Button variant="contained" endIcon={<SendIcon />} onClick={handleSubmit}>
              Submit
            </Button>
          </Card.Body>
        </Card>
      </section>
    </div>
  );
}

export default Contact