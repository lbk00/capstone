import './App.css'
import React from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import {Avatar, Box, ButtonGroup, Card, CardContent, Divider, Grid, Icon, Pagination} from '@mui/material';
import {green, lightGreen, red} from "@mui/material/colors";
import HomeIcon from '@mui/icons-material/Home';




export default function App() {
  return (
      <div className="App">
        <AppBar position="static">
          <Toolbar>
            <IconButton edge="start" color="inherit" aria-label="menu" sx={{ mr: 2 }}>
                <Icon sx={{ mr: 1 }} />
            </IconButton>
              <Typography align="left" variant="h6" sx={{ flexGrow: 1 }}>
              메인페이지
            </Typography>
            <Avatar>Lee</Avatar>
            <Button color="inherit">Login</Button>
            <Button color="inherit">Sign up</Button>
          </Toolbar>
        </AppBar>
        <Divider />
        <AppBar position="static">
          <Toolbar>
            <IconButton edge="start" color="inherit" aria-label="menu" sx={{ mr: 2 }}>
            </IconButton>
            <ButtonGroup variant="text" aria-label="Basic button group">
              <Button sx={{ color: 'black' }}>바지</Button>
              <Button sx={{ color: 'black' }}> 점퍼</Button>
              <Button sx={{ color: 'black' }}>운동화</Button>
              <Button sx={{ color: 'black' }}>트레이닝복</Button>
              <Button sx={{ color: 'black' }}>티셔츠</Button>
            </ButtonGroup>
          </Toolbar>
        </AppBar>
          <Grid container spacing={2} sx={{ padding: 2 }}>
              <Grid item xs={12} sm={6} md={4}>
                  <Card>
                      <CardContent>
                          테스트1
                      </CardContent>
                  </Card>
              </Grid>
              <Grid item xs={12} sm={6} md={4}>
                  <Card>
                      <CardContent>
                          테스트2
                      </CardContent>
                  </Card>
              </Grid>
              <Grid item xs={12} sm={6} md={4}>
                  <Card>
                      <CardContent>
                          테스트3
                      </CardContent>
                  </Card>
              </Grid>
              <Grid item xs={12} sm={6} md={4}>
                  <Card>
                      <CardContent>
                          테스트4
                      </CardContent>
                  </Card>
              </Grid>
              <Grid item xs={12} sm={6} md={4}>
                  <Card>
                      <CardContent>
                          테스트5
                      </CardContent>
                  </Card>
              </Grid>
              <Grid item xs={12} sm={6} md={4}>
                  <Card>
                      <CardContent>
                          테스트6
                      </CardContent>
                  </Card>
              </Grid>
          </Grid>
          <Box sx={{ display: 'flex', justifyContent: 'center', mt: 2 }}>
              <Pagination count={10} />
          </Box>
      </div>


  )
}
