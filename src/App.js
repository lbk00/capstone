import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignUp from './SignUp';
import Home from './Home';
import SignIn from './SignIn';

export default function App() {
  return (
    <Router>
      <Routes>
        <Route path="/signup" element={<SignUp />} />
        <Route path="/Home" element={<Home />} />
        <Route path="/signin" element={<SignIn />} />
        {/* 다른 라우트들... */}
      </Routes>
    </Router>
  )
}