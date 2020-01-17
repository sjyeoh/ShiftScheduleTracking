import {Entity, PrimaryGeneratedColumn, Column, ManyToOne, JoinColumn} from "typeorm";
import { User } from "./User";

@Entity()
export class UserRecord {

    @PrimaryGeneratedColumn()
    id: number;

    @Column({type:'date'})
    applyDate: Date;

    @Column()
    leaveType: string;

    @Column({type:'date'})
    createdAt: Date;

    @Column()
    createdBy: string;

    @Column({type:'date'})
    updatedAt: Date;

    @Column()
    updatedBy: string;

    @Column()
    updateFrequency: number;

    @ManyToOne(type=>User)
    @JoinColumn({name:'user_id'})
    user : User
}
