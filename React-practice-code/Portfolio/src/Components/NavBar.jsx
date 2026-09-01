import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import 'bootstrap/dist/css/bootstrap.min.css';
import { NavLink  } from 'react-router-dom';
import Home from './Home';


function NavBar() {
  return (
    <>
      <Navbar className="bg-[#0F172A]" data-bs-theme="dark" expand="lg">
        <Container>
          <Navbar.Brand className=' md:!text-3xl font-semibold font-mono'>Agnes Harris Fernando</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link as={NavLink} to="/" end>
                Home
              </Nav.Link>

              <Nav.Link as={NavLink} to="/about">
                About
              </Nav.Link>

              <Nav.Link as={NavLink} to="/skills">
                Skills
              </Nav.Link>

              <Nav.Link as={NavLink} to="/projects">
                Projects
              </Nav.Link>

              <Nav.Link as={NavLink} to="/experience">
                Experience
              </Nav.Link>

              <Nav.Link as={NavLink} to="/contact">
                Contact
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
}

export default NavBar;