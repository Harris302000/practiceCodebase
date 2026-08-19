import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';
import Home from './Home';


function NavBar() {
  return (
    <>
      <Navbar bg="success" data-bs-theme="dark" expand="lg" >
        <Container>
          <Navbar.Brand>Agnes Harris Fernando</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
           <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link as={Link} to={"/"} >Home</Nav.Link>
            <Nav.Link as={Link} to={"/about"}>About</Nav.Link>
            <Nav.Link as={Link} to={"/skills"}>Skills</Nav.Link>
            <Nav.Link as={Link} to={"/projects"}>Projects</Nav.Link>
            <Nav.Link as={Link} to={"/experience"}>Experience</Nav.Link>
            <Nav.Link as={Link} to={"/contact"}>Contact</Nav.Link>
          </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
}

export default NavBar;