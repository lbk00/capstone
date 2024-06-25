import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignUp from './SignUp';
import Home from './Home';

export default function App() {
  return (
    <Router>
      <Routes>
        <Route path="/signup" element={<SignUp />} />
        <Route path="/Home" element={<Home />} />
        {/* 다른 라우트들... */}
      </Routes>
    </Router>
  )
}