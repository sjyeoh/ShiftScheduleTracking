import {Entity, PrimaryGeneratedColumn, Column, PrimaryColumn} from "typeorm";

@Entity()
export class UserLog {

    @Column()
    id: number;

    @Column()
    fullName: string;

    @Column()
    team: number;

    @Column()
    totalLeave: number;

    @Column()
    status: string;

    @Column()
    access: string;

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


}
