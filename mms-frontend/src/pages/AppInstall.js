import React, { Component } from 'react'
import { Grid,Paper,Typography,Button, TextField } from '@material-ui/core'

export class AppInstall extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
            name1:"",
            address:"",
            email:"",
            phone:"",
            description:""
        };
        //this.submitfunction = this.submitfunction.bind;

    }
    
    // state={
    //     name:"",
    //     address:"",
    //     email:"",
    //     phone:"",
    //     description:""


    // };

    change = e =>{
        this.setState({
            [e.target.name]: e.target.value
        });
        //console.log(this)
    }

    submitfunction=()=>
    {
        console.log(this)
    }
    
    
    
    render() {
        const paperStyle = {padding:'30px 20px', width:400, margin:"20px auto"}
        return (
            <div>
                <Grid>
                    <Paper elevation="20" style={paperStyle}>
                        <h2>Organization Setup</h2>
                    <Typography variant='caption'>Fill up the information to setup an organization</Typography>

                    <Grid>
                    <form noValidate autoComplete="off">
                    <div>
                        
                        <TextField
                        id="outlined-basic"
                        type ="text"
                        fullWidth
                        label="Organization Name"
                        name = "name1"
                        value={this.state.name}
                        
                        placeholder="Name of Organization"
                        onChange={e => this.change(e)}
                        />
                      
                    </div>
                    <div>
                       
                    <TextField
                        label="Address"
                        name="address"
                        id="standard-basic"
                        type ="text"
                        fullWidth
                        placeholder="Physical office Adderess"
                        onChange={e => this.change(e)}

                        />
                     <div>
                        
                     <TextField
                        label="Email"
                        name="email"
                        id="standard-basic"
                        type ="email"
                        fullWidth
                        placeholder="Email of the Organization"
                        onChange={e => this.change(e)}

                        />
                      
                    </div>

                    <div>
                        
                    <TextField
                        label="Phone number"
                        name="phone"
                        id="standard-basic"
                        type ="tel"
                        placeholder=""
                        onChange={e => this.change(e)}

                        />
                      
                    </div>
                    <div>
                        
                    <TextField
                        label="Description"
                        name="description"
                        id="standard-basic"
                        type ="text"
                        fullWidth
                        multiline
                        rows="4"
                        placeholder="Describe your Organization"
                        onChange={e => this.change(e)}

                        />
                      
                    </div>
                    <br />
                    <br />
                    <div>
                    <Typography variant='caption'>Choose an appropriate picture for your organization</Typography>
                        <input type='file' />

                       
                    </div>
                    <br />
                    <br />

                    <div>
                        <Button variant='contained' color='primary' onClick={this.submitfunction}>Submit</Button>
                    </div>
                      
                    </div>

                </form>

                    </Grid>

                    </Paper>

                
                
                
                </Grid>
            </div>
        )
    }
}

export default AppInstall
