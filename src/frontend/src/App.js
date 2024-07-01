import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/Home';

export default function App() {
    return (
        <Router>
            <Routes>
                <Route path="/home" element={<Home />} />
            </Routes>
        </Router>

    )
}
