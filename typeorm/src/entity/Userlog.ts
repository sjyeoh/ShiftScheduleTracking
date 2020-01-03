import {Entity, PrimaryGeneratedColumn, Column, PrimaryColumn} from "typeorm";

@Entity()
export class UserLog {

    @PrimaryColumn()
    id: number;

    @Column()
    fullName: string;

    @Column()
    group: number;

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

    @PrimaryColumn()
    updateFrequency: number;


}
