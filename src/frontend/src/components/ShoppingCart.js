import React, { useState } from 'react';

import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import SearchIcon from '@mui/icons-material/Search';
import {
    Avatar,
    Box,
    Card,
    CardContent,
    CardMedia, Checkbox,
    Divider,
    Drawer,
    FormControl, FormControlLabel,
    Grid, Icon, InputAdornment,
    InputLabel,
    List,
    ListItem,
    ListItemButton,
    ListItemIcon,
    ListItemText,
    Menu,
    MenuItem,
    OutlinedInput,
    Select,
} from '@mui/material';

export default function App() {

    const [open, setOpen] = React.useState(false);
    const toggleDrawer = (newOpen) => () => {
        setOpen(newOpen);
    };
    const DrawerList = (
        <Box sx={{ width: 250 }} role="presentation" onClick={toggleDrawer(false)}>
            <List>
                {['전체보기'].map((text, index) => (
                    <ListItem key={text} disablePadding>
                        <ListItemButton>
                            <ListItemIcon>
                                <MenuIcon />
                            </ListItemIcon>
                            <ListItemText primary={text} />
                        </ListItemButton>
                    </ListItem>
                ))}
            </List>
            <Divider />
            <List>
                {['바지', '운동화', '트레이닝복', '티셔츠', '점퍼'].map((text, index) => (
                    <ListItem key={text} disablePadding>
                        <ListItemButton>
                            <ListItemIcon>
                                <MenuIcon />
                            </ListItemIcon>
                            <ListItemText primary={text} />
                        </ListItemButton>
                    </ListItem>
                ))}
            </List>
        </Box>
    );

    const [option1, setOption1] = React.useState('');
    const [option2, setOption2] = React.useState('');
    const [option3, setOption3] = React.useState('');

    const handleOption1Change = (event) => {
        setOption1(event.target.value);
    };

    const handleOption2Change = (event) => {
        setOption2(event.target.value);
    };

    const handleOption3Change = (event) => {
        setOption3(event.target.value);
    };

    {/*장바구니 상품 체크박스*/}
    const [checked, setChecked] = React.useState([true, false]);
    const handleChange1 = (event) => {
        setChecked([event.target.checked, event.target.checked]);
    };
    const handleChange2 = (event) => {
        setChecked([event.target.checked, checked[1]]);
    };
    const handleChange3 = (event) => {
        setChecked([checked[0], event.target.checked]);
    };
    {/*각 상품의 체크박스*/}
    const children = (
        <Box sx={{ display: 'flex', flexDirection: 'column', ml: 3 }}>
            <FormControlLabel
                label="상품 1"
                control={<Checkbox checked={checked[0]} onChange={handleChange2} />}
            />
            <div style={{ display: 'flex', alignItems: 'center' }}>
                {/*상품 이미지*/}
                <CardMedia
                    sx={{
                        height: 300,
                        width: 300,
                        marginRight: '20px'
                    }}
                    image={require("./sample/sample1.jpg")}
                    title="sample1"
                />
                <Divider orientation="vertical" variant="middle" flexItem />
                {/*상품 이름 및 가격*/}
                <CardContent sx={{ height: 300, width: 300, display: 'flex', flexDirection: 'column' }}>
                    <Typography gutterBottom variant="h5" component="div">
                        상품이름
                    </Typography>
                    <Typography variant="h6" color="text.secondary">
                        ₩ 10000
                    </Typography>
                </CardContent>
                <Divider orientation="vertical" variant="middle" flexItem />
            </div>
            <FormControlLabel
                label="상품 2"
                control={<Checkbox checked={checked[1]} onChange={handleChange3} />}
            />
        </Box>
    );

    return (
        <div className="App">
            <AppBar position="static" sx={{ bgcolor: 'white', color: 'black' }}>
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
            <AppBar position="static" sx={{ bgcolor: 'white', color: 'black'}}>
                <Toolbar>
                    <div>
                        <Button sx={{ color: 'black' }} onClick={toggleDrawer(true)}>
                            <MenuIcon/>
                        </Button>
                        <Drawer open={open} onClose={toggleDrawer(false)}>
                            {DrawerList}
                        </Drawer>
                    </div>

                    <Button sx={{ width : 90, color: 'black' }}>바지</Button>
                    <Divider orientation="vertical" variant="middle" flexItem />
                    <Button sx={{ width : 90, color: 'black' }}>운동화</Button>
                    <Divider orientation="vertical" variant="middle" flexItem />
                    <Button sx={{ width : 90, color: 'black' }}>트레이닝복</Button>
                    <Divider orientation="vertical" variant="middle" flexItem />
                    <Button sx={{ width : 90, color: 'black' }}>티셔츠</Button>
                    <Divider orientation="vertical" variant="middle" flexItem />
                    <Button sx={{ width : 90, color: 'black' }}>점퍼</Button>
                    <Box sx={{ flexGrow: 1 }} />
                    <form noValidate autoComplete="off">
                        <FormControl sx={{ width: '25ch', bgcolor: 'white' }} size="small">
                            <OutlinedInput
                                placeholder="검색어를 입력하세요"
                                sx={{
                                    '& .MuiOutlinedInput-notchedOutline': {
                                        borderColor: 'red',
                                        borderWidth: '2px',
                                    },
                                    '&:hover .MuiOutlinedInput-notchedOutline': {
                                        borderColor: 'red',
                                        borderWidth: '2px',
                                    },
                                    '&.Mui-focused .MuiOutlinedInput-notchedOutline': {
                                        borderColor: 'red',
                                        borderWidth: '2px',
                                    },
                                }}
                                endAdornment={
                                    <InputAdornment position="end">
                                        <IconButton edge="end">
                                            <SearchIcon />
                                        </IconButton>
                                    </InputAdornment>
                                }
                            />
                        </FormControl>
                    </form>
                </Toolbar>
            </AppBar>
            <Divider />
            {/*일반배송 ,장바구니 표시*/}
            <AppBar position="static" sx={{ bgcolor: 'white', color: 'black' }}>
            <Toolbar>
                <Grid container>
                    <Grid item xs={6}>
                        <Typography gutterBottom variant="h5">
                            일반배송 2
                        </Typography>
                    </Grid>
                    <Grid item xs={6} sx={{ display: 'flex', justifyContent: 'flex-end' }}>
                        <Typography gutterBottom variant="h5">
                            장바구니
                        </Typography>
                    </Grid>
                </Grid>
            </Toolbar>
            </AppBar>
            {/*장바구니*/}
            <Box
                sx={{
                    display: 'flex',
                    justifyContent: 'center',
                    height: '100vh',
                    bgcolor: '#ffffff',
                }}
            >
                <Card sx={{ bgcolor: '#f0f0f0' }}>
                    <CardContent sx={{ height: 500, width: 1300 }}>
                        <Grid container>
                            <Grid item xs={6}>
                                <div>
                                    <FormControlLabel
                                        label={
                                            <Typography variant="h5">
                                                전체선택
                                            </Typography>
                                        }
                                        control={
                                            <Checkbox
                                                checked={checked[0] && checked[1]}
                                                indeterminate={checked[0] !== checked[1]}
                                                onChange={handleChange1}
                                            />
                                        }
                                    />

                                    <Divider sx={{ borderBottomWidth: 3 , width: 1300}}/>
                                    {children}
                                </div>
                            </Grid>
                        </Grid>
                        <Divider />

                    </CardContent>
                </Card>
            </Box>


            <AppBar position="static" sx={{ bgcolor: 'gray', color: 'black', height: 50 }}>
                <Toolbar></Toolbar>
            </AppBar>
        </div>
    );
}
